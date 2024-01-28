/*
 * Copyright 2022 NAFU_at
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package page.nafuchoco.neobot.api.datastore;

import org.jetbrains.annotations.NotNull;

public interface DataStoreBuilder {
    /**
     * Returns {@link DataStore}.
     *
     * @return Built {@link DataStore}
     */
    DataStore build();

    /**
     * Sets the name of the data store.
     *
     * @param storeName the name of the data store<br>
     *                  This name is usually recommended for Camel case or Snake case.
     * @return this builder
     */
    DataStoreBuilder storeName(@NotNull String storeName);

    /**
     * Register the data items to be saved in the data store.
     *
     * @param clazz     the class of the data item
     * @param indexName the name of the index<br>
     *                  This name is usually recommended for Camel case or Snake case.
     * @return this builder
     */
    DataStoreBuilder addIndex(@NotNull Class clazz, @NotNull String indexName);

    /**
     * Deletes the specified item from the registered data items.
     *
     * @param indexName the name of the index
     * @return this builder
     */
    DataStoreBuilder removeIndex(@NotNull String indexName);
}
