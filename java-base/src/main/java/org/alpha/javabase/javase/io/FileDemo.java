package org.alpha.javabase.javase.io;

import java.io.File;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/19
 */
public class FileDemo {

    public static void main(String[] args) {
        FileDemo.dirTree(new File("/Users/liyazhou1/open-repo/nginx"));

    }


    /**
     * 递归删除文件夹
     */
    public void removeDir(File dir) {
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                removeDir(file);
            } else {
                System.out.println(file + ":" + file.delete());
            }
        }
        System.out.println(dir + ":" + dir.delete());
    }



    private static void dirTree(File dir) {
        dirTree(dir, 0);
    }

    private static void dirTree(File dir,int level) {
        System.out.println(getSpace(level) + dir.getName());

        level++;

        File[] files = dir.listFiles();

        for(int x=0; x<files.length; x++){

            if(files[x].isDirectory()){
                dirTree(files[x],level);
            }
            else {
                System.out.println(getSpace(level) + files[x].getName());
            }
        }
    }

    private static String getSpace(int level) {

        StringBuilder sb = new StringBuilder();

        sb.append("|--");
        for(int x=0; x<level; x++){
            sb.insert(0,"|  ");
        }

        return sb.toString();
    }
}
