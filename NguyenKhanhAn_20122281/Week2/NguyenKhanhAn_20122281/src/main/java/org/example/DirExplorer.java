/*
 * @ (#) DirExplorer.java 1.0 1/28/2024
 * copyright (c) 2024 KhanhNguyen. All right reserved
 */

package org.example;
import java.io.File;
/*
 * @description:
 * @author: NguyenKhanhAn
 * @date: 1/28/2024
 * @version: 1.0
 */
public class DirExplorer {
    public interface FileHandler {
        void handle(int level, String path, File file);
    }
    // interface for file filter
    public interface Filter {
        boolean interested(int level, String path, File file);
    }
    private FileHandler fileHandler;
    private Filter filter;
    public DirExplorer(Filter filter, FileHandler fileHandler) {
        this.filter = filter;
        this.fileHandler = fileHandler;
    }
    public void explore(File root) {
        explore(0, "", root);
    }
    private void explore(int level, String path, File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                explore(level + 1, path + "/" + child.getName(), child);
            }
        } else {
            if (filter.interested(level, path, file)) {
                fileHandler.handle(level, path, file);
            }
        }
    }
}
