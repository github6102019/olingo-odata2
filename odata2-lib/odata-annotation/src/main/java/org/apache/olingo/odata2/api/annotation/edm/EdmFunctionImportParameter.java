/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.olingo.odata2.api.annotation.edm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Annotation for definition of an {@link EdmFunctionImportParameter} for an {@link EdmFunctionImport}
 * which contains the {@link EdmFunctionImportParameter} as a parameter.</p>
 * The EdmProperty annotation has to be used on a parameter within a {@link EdmFunctionImport} annotated method.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface EdmFunctionImportParameter {
  /**
   * Define the name for the Function Import Parameter.
   * If not set a default value has to be generated by the EDM provider.
   * 
   * @return name for the Function Import Parameter
   */
  String name();
  /**
   * Define the EdmSimpleType which is used for the Function Import Parameter in the EDM.
   * <p>
   * If not explicit set a default value has to be generated by the EDM provider (which should be compatible to the 
   * java type of the annotated field).
   * <p>
   * If the property is a simple property a EdmSimpleType must be used which can be mapped to the
   * java type of the annotated field. Which mappings are available depends on the used implementation.
   * <p>
   * If the property is a EdmComplexType (and no EdmSimpleType) the type <code>COMPLEX</code> must be used.
   * 
   * @return type for the Function Import Parameter as used in the EDM
   */
  EdmType type() default EdmType.NULL;
  /**
   * Define the EdmFacets for the Function Import Parameter in the EDM.
   * If not set the default EdmFacet values are used (see {@link EdmFacets}).
   * 
   * @return facets for the Function Import Parameter as used in the EDM
   */
  EdmFacets facets() default @EdmFacets;
}