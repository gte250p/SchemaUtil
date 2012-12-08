package org.gtri.xml.schema.parser

import org.junit.Test

class TestHeaderResolverImpl extends AbstractTest {

    @Test
    public void testFindAllFiles() {
        logger.info("Finding all files...")
        def resolver = new HeaderResolverImpl();
        resolver.resolve(new File("./src/test/resources/schema1"))

        logger.info("Testing successful!");
    }//end testFindAllFiles


}//end TestHeaderResolverImpl