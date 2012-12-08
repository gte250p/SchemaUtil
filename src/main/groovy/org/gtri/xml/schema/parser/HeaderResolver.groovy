package org.gtri.xml.schema.parser

import org.apache.commons.vfs2.FileObject

//import org.apache.commons.vfs2.FileObject
import org.apache.commons.vfs2.FileSystemManager
import org.apache.commons.vfs2.VFS
import org.apache.log4j.Logger
import org.gtri.xml.schema.dom.Header

/**
 *
 * <br/><br/>
 * User: brad
 * Date: 12/8/2012 1:56 PM
 */
class HeaderResolverImpl implements HeaderResolver {

    private static Logger logger = Logger.getLogger(HeaderResolverImpl)

    public List<List<Header>> resolve(File file) {
        resolve(file.canonicalPath)
    }

    public List<List<Header>> resolve(String location) {
        logger.debug "Resolving location: $location"
        FileSystemManager fsManager = VFS.getManager();
        FileObject object = fsManager.resolveFile(location);
        List<FileObject> allObjects = [object]
        allObjects.addAll(flatten(object))

        logger.info("Resolved File Objects: ")
        allObjects.each { obj ->
            logger.info("   Object: ${obj.getName().toString()}")
        }

        return []
    }//end resolve()



    private List<FileObject> flatten( FileObject fileObject ) {
        List<FileObject> children = []

        List<FileObject> depthFirstSearchList = []
        fileObject.getChildren()?.each { child ->
            children.add( child )
            depthFirstSearchList.add( child )
        }
        depthFirstSearchList.each { child ->
            children.addAll(flatten(child))
        }
        return children
    }

}//end HeaderResolverImpl


interface HeaderResolver {

    public List<List<Header>> resolve(File file);

    public List<List<Header>> resolve(String location);

}//end HeaderResolver