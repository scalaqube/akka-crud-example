package com.eweise

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.eweise.domain.repository.TaskRepository
import com.eweise.domain.service.TaskService
import com.eweise.intf.{Database, HttpServer}
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.StrictLogging

import scala.io.StdIn

object Boot extends App with StrictLogging {
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    implicit val taskRepo = new TaskRepository()
    implicit val taskService = new TaskService()

    val config = ConfigFactory.load()
    val dbConfig = config.getConfig("database")
    val dbPoolConfiguration = new Database(dbConfig)
    val serverBinding = new HttpServer().start()

    println("migrating...")
    new Migrator(dbConfig).flyway

    println("server is ready")
    StdIn.readLine()
    // Unbind from the port and shut down when done
    serverBinding
            .flatMap(_.unbind())
            .onComplete(_ => system.terminate())
}
