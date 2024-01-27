/*
 * @ (#) ListClassesExample.java 1.0 1/28/2024
 * copyright (c) 2024 KhanhNguyen. All right reserved
 */

package org.example;
import java.io.File;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
/*
 * @description:
 * @author: NguyenKhanhAn
 * @date: 1/28/2024
 * @version: 1.0
 */
public class ListClassesExample {
    public static void listClasses(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path,
                                                                        file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" * " + n.getName());
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);
    }
    public static void main(String[] args) {
        File projectDir = new File("E:\\HocDaiHoc\\Ki_8\\KienTruc\\SoftwareArchitecture\\NguyenKhanhAn_20122281\\Week2\\NguyenKhanhAn_20122281\\src\\main\\java\\org\\example");
        listClasses(projectDir);
    }
}
