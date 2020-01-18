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

package io.vertx.scala.ext.web.handler

import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.handler.{BodyHandler => JBodyHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A handler which gathers the entire request body and sets it on the .
  * 
  * It also handles HTTP file uploads and can be used to limit body sizes.
  */

class BodyHandler(private val _asJava: Object) extends io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava



  /**
   * Set whether file uploads will be handled   * @param handleFileUploads true if they should be handled
   * @return reference to this for fluency
   */
  
  def setHandleFileUploads(handleFileUploads: Boolean): BodyHandler = {
    asJava.asInstanceOf[JBodyHandler].setHandleFileUploads(handleFileUploads.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set the maximum body size -1 means unlimited   * @param bodyLimit the max size
   * @return reference to this for fluency
   */
  
  def setBodyLimit(bodyLimit: Long): BodyHandler = {
    asJava.asInstanceOf[JBodyHandler].setBodyLimit(bodyLimit.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Set the uploads directory to use   * @param uploadsDirectory the uploads directory
   * @return reference to this for fluency
   */
  
  def setUploadsDirectory(uploadsDirectory: String): BodyHandler = {
    asJava.asInstanceOf[JBodyHandler].setUploadsDirectory(uploadsDirectory.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set whether form attributes will be added to the request parameters   * @param mergeFormAttributes true if they should be merged
   * @return reference to this for fluency
   */
  
  def setMergeFormAttributes(mergeFormAttributes: Boolean): BodyHandler = {
    asJava.asInstanceOf[JBodyHandler].setMergeFormAttributes(mergeFormAttributes.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set whether uploaded files should be removed after handling the request   * @param deleteUploadedFilesOnEnd true if uploaded files should be removed after handling the request
   * @return reference to this for fluency
   */
  
  def setDeleteUploadedFilesOnEnd(deleteUploadedFilesOnEnd: Boolean): BodyHandler = {
    asJava.asInstanceOf[JBodyHandler].setDeleteUploadedFilesOnEnd(deleteUploadedFilesOnEnd.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Pre-allocate the body buffer according to the value parsed from content-length header.
   * The buffer is capped at 64KB   * @param isPreallocateBodyBuffer `true` if body buffer is pre-allocated according to the size read from content-length Header. {code false` if body buffer is pre-allocated to 1KB, and is resized dynamically
   * @return reference to this for fluency
   */
  
  def setPreallocateBodyBuffer(isPreallocateBodyBuffer: Boolean): BodyHandler = {
    asJava.asInstanceOf[JBodyHandler].setPreallocateBodyBuffer(isPreallocateBodyBuffer.asInstanceOf[java.lang.Boolean])
    this
  }




  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JBodyHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }


}

object BodyHandler {
  def apply(asJava: JBodyHandler) = new BodyHandler(asJava)

  /**
   * Create a body handler with defaults   * @return the body handler
   */
  def create(): BodyHandler = {
    BodyHandler(JBodyHandler.create())//2 create
  }

  /**
   * Create a body handler setting if it should handle file uploads   * @param handleFileUploads true if files upload should be handled
   * @return the body handler
   */
  def create(handleFileUploads: Boolean): BodyHandler = {
    BodyHandler(JBodyHandler.create(handleFileUploads.asInstanceOf[java.lang.Boolean]))//2 create
  }

  /**
   * Create a body handler and use the given upload directory.   * @param uploadDirectory the uploads directory
   * @return the body handler
   */
  def create(uploadDirectory: String): BodyHandler = {
    BodyHandler(JBodyHandler.create(uploadDirectory.asInstanceOf[java.lang.String]))//2 create
  }

}
