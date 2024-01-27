/*
 * @ (#) CommonOperations.java 1.0 1/28/2024
 * copyright (c) 2024 KhanhNguyen. All right reserved
 */

package org.example;
import java.io.File;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
/*
 * @description:
 * @author: NguyenKhanhAn
 * @date: 1/28/2024
 * @version: 1.0
 */
public class CommonOperations {
    public static void listMethodCalls(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level,path, file) -> {
            System.out.println();
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(PackageDeclaration n, Object arg)
                    {
                        super.visit(n, arg);
                        System.out.println(n.getNameAsString());
                    }
                    @Override
                    public void visit(FieldDeclaration n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" [L " + n.getBegin() + "]" + n);
                }
                @Override
                    public void visit(MethodDeclaration n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" [L " + n.getBegin() + "]" + n.getDeclarationAsString());
                    }

                }.visit(StaticJavaParser.parse(file), null);
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }).explore(projectDir); // explore is a method of DirExplorer       
    }
    public static void main(String[] args) {
        File projectDir = new File("E:\\HocDaiHoc\\Ki_8\\KienTruc\\SoftwareArchitecture\\NguyenKhanhAn_20122281\\Week2\\NguyenKhanhAn_20122281\\src\\main\\java\\org\\example");
        listMethodCalls(projectDir);
    }
}
