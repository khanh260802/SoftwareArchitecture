/*
 * @ (#) NodeIterator.java 1.0 1/28/2024
 * copyright (c) 2024 KhanhNguyen. All right reserved
 */

package org.example;
import com.github.javaparser.ast.Node;
/*
 * @description:
 * @author: NguyenKhanhAn
 * @date: 1/28/2024
 * @version: 1.0
 */
public class NodeIterator {
    public interface NodeHandler {
        boolean handle(Node node);
    }
    private NodeHandler nodeHandler;
    public NodeIterator(NodeHandler nodeHandler) {
        this.nodeHandler = nodeHandler;
    }
    public void explore(Node    node) {
        if (nodeHandler.handle(node)) {
            for (Node child : node.getChildNodes()) {
                explore(child);
            }
        }
    }
}
