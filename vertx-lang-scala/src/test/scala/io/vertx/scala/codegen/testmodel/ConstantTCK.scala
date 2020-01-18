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

package io.vertx.scala.codegen.testmodel

import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{ConstantTCK => JConstantTCK}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import scala.reflect.runtime.universe._
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._


class ConstantTCK(private val _asJava: Object) {
  def asJava = _asJava






}

object ConstantTCK {
  def apply(asJava: JConstantTCK) = new ConstantTCK(asJava)

}
