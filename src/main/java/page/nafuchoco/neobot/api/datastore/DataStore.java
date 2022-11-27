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

public interface DataStore {
    String getName();

    /**
     * Gets the data stored in the data store.
     *
     * @param id    The guild id of the data to get.
     * @param index The index of the data to get.
     * @return The data stored in the data store.
     */
    <T> T getStoreData(long id, String index);

    /**
     * Update the data registered in the data store.
     *
     * @param id    The guild id of the data to save.
     * @param index The index of the data to save.
     * @param value The value of the data to save.
     * @param <T>   The type of the data to save.
     */
    <T> void saveStoreData(long id, String index, T value);

    /**
     * Register the data with the new ID in the data store.
     *
     * @param id     The guild id of the data to register.
     * @param values The values of the data to register.
     *               The order of the values must be the same as the order of the indexes.
     */
    void registerStoreData(Long id, Object... values);

    /**
     * Deletes the data stored in the data store.
     *
     * @param id The guild id of the data to delete.
     */
    void deleteStoredData(long id);
}
