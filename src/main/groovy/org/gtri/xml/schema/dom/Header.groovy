package org.gtri.xml.schema.dom

/**
 * Represents high-level metadata about a schema, including imports.
 * <br/><br/>
 * User: brad
 * Date: 12/8/2012 1:53 PM
 */
class Header {

    String fileName = null
    String version = null
    String namespaceUri = null

    public Map<String, String> importUris = [:]
    public Map<String, String> includeUris = [:]
    public Map<String, String> xsiSchemaLocationUris = [:]


}//end Header()