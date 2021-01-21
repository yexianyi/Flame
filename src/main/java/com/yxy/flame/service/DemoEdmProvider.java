/*
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
 */
package com.yxy.flame.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.provider.CsdlAbstractEdmProvider;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainer;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainerInfo;
import org.apache.olingo.commons.api.edm.provider.CsdlEntitySet;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityType;
import org.apache.olingo.commons.api.edm.provider.CsdlNavigationProperty;
import org.apache.olingo.commons.api.edm.provider.CsdlNavigationPropertyBinding;
import org.apache.olingo.commons.api.edm.provider.CsdlProperty;
import org.apache.olingo.commons.api.edm.provider.CsdlPropertyRef;
import org.apache.olingo.commons.api.edm.provider.CsdlSchema;

public class DemoEdmProvider extends CsdlAbstractEdmProvider {

    // Service Namespace
    public static final String NAMESPACE = "OData.Demo";

    // EDM Container
    public static final String CONTAINER_NAME = "Container";
    public static final FullQualifiedName CONTAINER = new FullQualifiedName(NAMESPACE, CONTAINER_NAME);

    // Entity Types Names
    public static final String ET_ENTERPRISE_NAME = "Enterprise";
    public static final FullQualifiedName ET_ENTERPRISE_FQN = new FullQualifiedName(NAMESPACE, ET_ENTERPRISE_NAME);
    
    public static final String ET_SITE_NAME = "Site";
    public static final FullQualifiedName ET_SITE_FQN = new FullQualifiedName(NAMESPACE, ET_SITE_NAME);
    
    public static final String ET_AREA_NAME = "Area";
    public static final FullQualifiedName ET_AREA_FQN = new FullQualifiedName(NAMESPACE, ET_AREA_NAME);
    
    public static final String ET_PRODUCT_LINE_NAME = "ProductLine";
    public static final FullQualifiedName ET_PRODUCT_LINE_FQN = new FullQualifiedName(NAMESPACE, ET_PRODUCT_LINE_NAME);
    
    public static final String ET_PRODUCT_NAME = "Product";
    public static final FullQualifiedName ET_PRODUCT_FQN = new FullQualifiedName(NAMESPACE, ET_PRODUCT_NAME);


    // Entity Set Names
    public static final String ES_ENTERPRISES_NAME = "Enterprises";
    public static final String ES_SITES_NAME = "Sites";
    public static final String ES_AREAS_NAME = "Areas";
    public static final String ES_PRODUCT_LINES_NAME = "ProductLines";
    public static final String ES_PRODUCTS_NAME = "Products";

    @Override
    public CsdlEntityType getEntityType(FullQualifiedName entityTypeName) {

        // this method is called for each EntityType that are configured in the Schema
        CsdlEntityType entityType = null;
        if (entityTypeName.equals(ET_ENTERPRISE_FQN)) {
            // create EntityType properties
            CsdlProperty id =
                    new CsdlProperty().setName("ID").setType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName());
            CsdlProperty name =
                    new CsdlProperty().setName("Name").setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
            CsdlProperty description = new CsdlProperty().setName("Description")
                    .setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());

            // create PropertyRef for Key element
            CsdlPropertyRef propertyRef = new CsdlPropertyRef();
            propertyRef.setName("ID");
            
//            // navigation property: one-to-many
            CsdlNavigationProperty navProp = new CsdlNavigationProperty().setName("Sites").setType(ET_SITE_FQN)
                    .setCollection(true) ;
            List<CsdlNavigationProperty> navPropList = new ArrayList<CsdlNavigationProperty>();
            navPropList.add(navProp);

            // configure EntityType
            entityType = new CsdlEntityType();
            entityType.setName(ET_ENTERPRISE_NAME);
            entityType.setProperties(Arrays.asList(id, name, description));
            entityType.setKey(Arrays.asList(propertyRef));
            entityType.setNavigationProperties(navPropList) ;

        }
        
        if (entityTypeName.equals(ET_SITE_FQN)) {
            // create EntityType properties
            CsdlProperty id =
                    new CsdlProperty().setName("ID").setType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName());
            CsdlProperty name =
                    new CsdlProperty().setName("Name").setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
            CsdlProperty description = new CsdlProperty().setName("Description")
                    .setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());

            // create PropertyRef for Key element
            CsdlPropertyRef propertyRef = new CsdlPropertyRef();
            propertyRef.setName("ID");

            // navigation property: one-to-many
            CsdlNavigationProperty navProp = new CsdlNavigationProperty().setName("Areas").setType(ET_AREA_FQN)
                    .setCollection(true) ;
            List<CsdlNavigationProperty> navPropList = new ArrayList<CsdlNavigationProperty>();
            navPropList.add(navProp);
            
            // configure EntityType
            entityType = new CsdlEntityType();
            entityType.setName(ET_SITE_NAME);
            entityType.setProperties(Arrays.asList(id, name, description));
            entityType.setKey(Arrays.asList(propertyRef));
            entityType.setNavigationProperties(navPropList) ;
        }
        
        if (entityTypeName.equals(ET_AREA_FQN)) {
            // create EntityType properties
            CsdlProperty id =
                    new CsdlProperty().setName("ID").setType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName());
            CsdlProperty name =
                    new CsdlProperty().setName("Name").setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
            CsdlProperty description = new CsdlProperty().setName("Description")
                    .setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());

            // create PropertyRef for Key element
            CsdlPropertyRef propertyRef = new CsdlPropertyRef();
            propertyRef.setName("ID");

            // navigation property: one-to-many
            CsdlNavigationProperty navProp = new CsdlNavigationProperty().setName("ProductLines").setType(ET_PRODUCT_LINE_FQN)
                    .setCollection(true) ;
            List<CsdlNavigationProperty> navPropList = new ArrayList<CsdlNavigationProperty>();
            navPropList.add(navProp);
            
            // configure EntityType
            entityType = new CsdlEntityType();
            entityType.setName(ET_AREA_NAME);
            entityType.setProperties(Arrays.asList(id, name, description));
            entityType.setKey(Arrays.asList(propertyRef));
            entityType.setNavigationProperties(navPropList) ;
        }
        
        if (entityTypeName.equals(ET_PRODUCT_LINE_FQN)) {
            // create EntityType properties
            CsdlProperty id =
                    new CsdlProperty().setName("ID").setType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName());
            CsdlProperty name =
                    new CsdlProperty().setName("Name").setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
            CsdlProperty description = new CsdlProperty().setName("Description")
                    .setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());

            // create PropertyRef for Key element
            CsdlPropertyRef propertyRef = new CsdlPropertyRef();
            propertyRef.setName("ID");

            // navigation property: one-to-many
            CsdlNavigationProperty navProp = new CsdlNavigationProperty().setName("Products").setType(ET_PRODUCT_FQN)
                    .setCollection(true) ;
            List<CsdlNavigationProperty> navPropList = new ArrayList<CsdlNavigationProperty>();
            navPropList.add(navProp);
            
            // configure EntityType
            entityType = new CsdlEntityType();
            entityType.setName(ET_PRODUCT_LINE_NAME);
            entityType.setProperties(Arrays.asList(id, name, description));
            entityType.setKey(Arrays.asList(propertyRef));
            entityType.setNavigationProperties(navPropList) ;
        }
        
        if (entityTypeName.equals(ET_PRODUCT_FQN)) {
            // create EntityType properties
            CsdlProperty id =
                    new CsdlProperty().setName("ID").setType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName());
            CsdlProperty name =
                    new CsdlProperty().setName("Name").setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
            CsdlProperty description = new CsdlProperty().setName("Description")
                    .setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());

            // create PropertyRef for Key element
            CsdlPropertyRef propertyRef = new CsdlPropertyRef();
            propertyRef.setName("ID");

            // navigation property: many-to-one, null not allowed (product must have a category)
//            CsdlNavigationProperty navProp = new CsdlNavigationProperty().setName("Category").setType(ET_CATEGORY_FQN)
//                    .setNullable(false).setPartner("Products");
//            List<CsdlNavigationProperty> navPropList = new ArrayList<CsdlNavigationProperty>();
//            navPropList.add(navProp);

            // configure EntityType
            entityType = new CsdlEntityType();
            entityType.setName(ET_PRODUCT_NAME);
            entityType.setProperties(Arrays.asList(id, name, description));
            entityType.setKey(Arrays.asList(propertyRef));
//            entityType.setNavigationProperties(navPropList);

        } 
//        else if (entityTypeName.equals(ET_CATEGORY_FQN)) {
//            // create EntityType properties
//            CsdlProperty id =
//                    new CsdlProperty().setName("ID").setType(EdmPrimitiveTypeKind.Int32.getFullQualifiedName());
//            CsdlProperty name =
//                    new CsdlProperty().setName("Name").setType(EdmPrimitiveTypeKind.String.getFullQualifiedName());
//
//            // create PropertyRef for Key element
//            CsdlPropertyRef propertyRef = new CsdlPropertyRef();
//            propertyRef.setName("ID");
//
//            // navigation property: one-to-many
//            CsdlNavigationProperty navProp = new CsdlNavigationProperty().setName("Products").setType(ET_PRODUCT_FQN)
//                    .setCollection(true).setPartner("Category");
//            List<CsdlNavigationProperty> navPropList = new ArrayList<CsdlNavigationProperty>();
//            navPropList.add(navProp);
//
//            // configure EntityType
//            entityType = new CsdlEntityType();
//            entityType.setName(ET_CATEGORY_NAME);
//            entityType.setProperties(Arrays.asList(id, name));
//            entityType.setKey(Arrays.asList(propertyRef));
//            entityType.setNavigationProperties(navPropList);
//        }


        return entityType;

    }

    @Override
    public CsdlEntitySet getEntitySet(FullQualifiedName entityContainer, String entitySetName) {

        CsdlEntitySet entitySet = null;

        if (entityContainer.equals(CONTAINER)) {

            if (entitySetName.equals(ES_PRODUCTS_NAME)) {

                entitySet = new CsdlEntitySet();
                entitySet.setName(ES_PRODUCTS_NAME);
                entitySet.setType(ET_PRODUCT_FQN);

                // navigation
                CsdlNavigationPropertyBinding navPropBinding = new CsdlNavigationPropertyBinding();
                navPropBinding.setTarget("Categories"); // the target entity set, where the navigation property points
                                                        // to
                navPropBinding.setPath("Category"); // the path from entity type to navigation property
                List<CsdlNavigationPropertyBinding> navPropBindingList = new ArrayList<CsdlNavigationPropertyBinding>();
                navPropBindingList.add(navPropBinding);
                entitySet.setNavigationPropertyBindings(navPropBindingList);

            } 

            if (entitySetName.equals(ES_ENTERPRISES_NAME)) {

                entitySet = new CsdlEntitySet();
                entitySet.setName(ES_ENTERPRISES_NAME);
                entitySet.setType(ET_ENTERPRISE_FQN);

                // navigation
//                CsdlNavigationPropertyBinding navPropBinding = new CsdlNavigationPropertyBinding();
//                navPropBinding.setTarget("Products"); // the target entity set, where the navigation property points to
//                navPropBinding.setPath("Products"); // the path from entity type to navigation property
//                List<CsdlNavigationPropertyBinding> navPropBindingList = new ArrayList<CsdlNavigationPropertyBinding>();
//                navPropBindingList.add(navPropBinding);
//                entitySet.setNavigationPropertyBindings(navPropBindingList);
            }
            
            if (entitySetName.equals(ES_SITES_NAME)) {

                entitySet = new CsdlEntitySet();
                entitySet.setName(ES_SITES_NAME);
                entitySet.setType(ET_SITE_FQN);

            }
            
            if (entitySetName.equals(ES_AREAS_NAME)) {

                entitySet = new CsdlEntitySet();
                entitySet.setName(ES_AREAS_NAME);
                entitySet.setType(ET_AREA_FQN);

            }
            
            if (entitySetName.equals(ES_PRODUCT_LINES_NAME)) {

                entitySet = new CsdlEntitySet();
                entitySet.setName(ES_PRODUCT_LINES_NAME);
                entitySet.setType(ET_PRODUCT_LINE_FQN);

            }

        }

        return entitySet;
    }

    @Override
    public CsdlEntityContainerInfo getEntityContainerInfo(FullQualifiedName entityContainerName) {

        // This method is invoked when displaying the service document at
        // e.g. http://localhost:8080/DemoService/DemoService.svc
        if (entityContainerName == null || entityContainerName.equals(CONTAINER)) {
            CsdlEntityContainerInfo entityContainerInfo = new CsdlEntityContainerInfo();
            entityContainerInfo.setContainerName(CONTAINER);
            return entityContainerInfo;
        }

        return null;
    }

    @Override
    public List<CsdlSchema> getSchemas() {
        // create Schema
        CsdlSchema schema = new CsdlSchema();
        schema.setNamespace(NAMESPACE);

        // add EntityTypes
        List<CsdlEntityType> entityTypes = new ArrayList<CsdlEntityType>();
        entityTypes.add(getEntityType(ET_ENTERPRISE_FQN));
        entityTypes.add(getEntityType(ET_SITE_FQN));
        entityTypes.add(getEntityType(ET_AREA_FQN));
        entityTypes.add(getEntityType(ET_PRODUCT_LINE_FQN));
        entityTypes.add(getEntityType(ET_PRODUCT_FQN));
        schema.setEntityTypes(entityTypes);

        // add EntityContainer
        schema.setEntityContainer(getEntityContainer());

        // finally
        List<CsdlSchema> schemas = new ArrayList<CsdlSchema>();
        schemas.add(schema);

        return schemas;
    }

    @Override
    public CsdlEntityContainer getEntityContainer() {

        // create EntitySets
        List<CsdlEntitySet> entitySets = new ArrayList<CsdlEntitySet>();
        entitySets.add(getEntitySet(CONTAINER, ES_ENTERPRISES_NAME));
        entitySets.add(getEntitySet(CONTAINER, ES_SITES_NAME));
        entitySets.add(getEntitySet(CONTAINER, ES_AREAS_NAME));
        entitySets.add(getEntitySet(CONTAINER, ES_PRODUCT_LINES_NAME));
        entitySets.add(getEntitySet(CONTAINER, ES_PRODUCTS_NAME));

        // create EntityContainer
        CsdlEntityContainer entityContainer = new CsdlEntityContainer();
        entityContainer.setName(CONTAINER_NAME);
        entityContainer.setEntitySets(entitySets);

        return entityContainer;
    }
}
