/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.mail

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.mail.{MailConfig => JMailConfig}
import scala.reflect.runtime.universe._
import io.vertx.ext.mail.{MailResult => JMailResult}
import io.vertx.ext.mail.{MailClient => JMailClient}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.ext.mail.{MailMessage => JMailMessage}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * SMTP mail client for Vert.x
  * 
  * A simple asynchronous API for sending mails from Vert.x applications
  */

class MailClient(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * send a single mail via MailClient   * @param email MailMessage object containing the mail text, from/to, attachments etc see <a href="../../../../../../../cheatsheet/MailMessage.html">MailMessage</a>
   * @param resultHandler will be called when the operation is finished or it fails (may be null to ignore the result)
   * @return this MailClient instance so the method can be used fluently
   */
  
  def sendMail(email: MailMessage, resultHandler: Handler[AsyncResult[MailResult]]): MailClient = {
    asJava.asInstanceOf[JMailClient].sendMail(email.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMailResult]]{def handle(x: AsyncResult[JMailResult]) {resultHandler.handle(AsyncResultWrapper[JMailResult, MailResult](x, a => MailResult(a)))}}))
    this
  }



  /**
   * close the MailClient
   */
  def close (): Unit = {
    asJava.asInstanceOf[JMailClient].close()
  }


 /**
  * Like [[sendMail]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendMailFuture (email: MailMessage): scala.concurrent.Future[MailResult] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMailResult, MailResult](x => MailResult(x))
    asJava.asInstanceOf[JMailClient].sendMail(email.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MailClient {
  def apply(asJava: JMailClient) = new MailClient(asJava)

  /**
   */
  def createNonShared(vertx: Vertx,config: MailConfig): MailClient = {
    MailClient(JMailClient.createNonShared(vertx.asJava.asInstanceOf[JVertx], config.asJava))//2 createNonShared
  }

  /**
   * Create a non shared instance of the mail client.   * @param vertx the Vertx instance the operation will be run in
   * @param config MailConfig configuration to be used for sending mails see <a href="../../../../../../../cheatsheet/MailConfig.html">MailConfig</a>
   * @return MailClient instance that can then be used to send multiple mails
   */
  def create(vertx: Vertx,config: MailConfig): MailClient = {
    MailClient(JMailClient.create(vertx.asJava.asInstanceOf[JVertx], config.asJava))//2 create
  }

  /**
   * Create a Mail client which shares its connection pool with any other Mail clients created with the same
   * pool name   * @param vertx the Vert.x instance
   * @param config the configuration see <a href="../../../../../../../cheatsheet/MailConfig.html">MailConfig</a>
   * @param poolName the pool name
   * @return the client
   */
  def createShared(vertx: Vertx,config: MailConfig,poolName: String): MailClient = {
    MailClient(JMailClient.createShared(vertx.asJava.asInstanceOf[JVertx], config.asJava, poolName.asInstanceOf[java.lang.String]))//2 createShared
  }

  /**
   * Like [[io.vertx.scala.ext.mail.MailClient#createShared]] but with the default pool name   * @param vertx the Vert.x instance
   * @param config the configuration see <a href="../../../../../../../cheatsheet/MailConfig.html">MailConfig</a>
   * @return the client
   */
  def createShared(vertx: Vertx,config: MailConfig): MailClient = {
    MailClient(JMailClient.createShared(vertx.asJava.asInstanceOf[JVertx], config.asJava))//2 createShared
  }

}
