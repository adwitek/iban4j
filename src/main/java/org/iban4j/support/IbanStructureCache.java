/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.iban4j.support;

import java.io.IOException;
import java.util.Properties;

public class IbanStructureCache {

    private static final String DEFAULT_PROPERTIES_FILE = "iban.properties";

    private static IbanConfiguration configuration = doConfigure();

    private IbanStructureCache() {
    }

    public static IbanStructure getStructure(String countryCode) {
        return configuration.getStructure(countryCode);
    }

    private static IbanConfiguration doConfigure() throws IllegalStateException {
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtil.loadProperties(DEFAULT_PROPERTIES_FILE);
        } catch (IOException e) {
            throw new IllegalStateException("Can not find configuration file", e);
        }
        return new IbanConfiguration(properties);
    }


}
