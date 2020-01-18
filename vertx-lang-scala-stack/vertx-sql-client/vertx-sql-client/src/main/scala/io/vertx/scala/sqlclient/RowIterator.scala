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

package io.vertx.scala.sqlclient

import io.vertx.sqlclient.{RowIterator => JRowIterator}
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * An iterator for processing rows.

  */

class RowIterator[R: TypeTag](private val _asJava: Object) {
  def asJava = _asJava






  def hasNext (): Boolean = {
    asJava.asInstanceOf[JRowIterator[Object]].hasNext().asInstanceOf[Boolean]
  }


  def next (): R = {
    toScala[R](asJava.asInstanceOf[JRowIterator[Object]].next())
  }


}

object RowIterator {
  def apply[R: TypeTag](asJava: JRowIterator[_]) = new RowIterator[R](asJava)

}
