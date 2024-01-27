package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File projectDir = new File("E:\\HocDaiHoc\\Ki_8\\KienTruc\\SoftwareArchitecture\\NguyenKhanhAn_20122281\\Week2\\NguyenKhanhAn_20122281\\src\\main\\java\\org\\example");
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
        }).explore(projectDir);
    }
}