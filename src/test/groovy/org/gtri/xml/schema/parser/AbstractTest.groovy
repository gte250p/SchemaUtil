package org.gtri.xml.schema.parser

import org.apache.log4j.Logger
import org.junit.After
import org.junit.Before

/**
 * Abstraction above all JUnit Tests to provide logger & other global functionality.
 * <br/><br/>
 * User: brad
 * Date: 12/8/2012 2:12 PM
 */
class AbstractTest {

    protected static Logger logger = Logger.getLogger(AbstractTest.class)

    @Before
    public void printStarting() {
        logger.info("============================== STARTING TEST ==============================")
    }
    @After
    public void printStopping() {
        logger.info("============================== STOPPING TEST ==============================\n\n")
    }

}//end AbstractTest