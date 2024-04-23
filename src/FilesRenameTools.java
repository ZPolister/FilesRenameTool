import java.io.File;

public class FilesRenameTools {
    private String oldSeparator;
    private String newSeparator;
    private String workPath;

    public FilesRenameTools(String oldSeparator, String newSeparator, String workPath) {
        this.oldSeparator = oldSeparator;
        this.newSeparator = newSeparator;
        this.workPath = workPath;
    }
    public String getOldSeparator() {
        return oldSeparator;
    }

    public void setOldSeparator(String oldSeparator) {
        this.oldSeparator = oldSeparator;
    }

    public String getNewSeparator() {
        return newSeparator;
    }

    public void setNewSeparator(String newSeparator) {
        this.newSeparator = newSeparator;
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }

    public void startRename() {
        File workDirectory = new File(getWorkPath());
        if (!workDirectory.exists() || !workDirectory.isDirectory()) {
            throw new RuntimeException("目录不存在");
        }

        File[] files = workDirectory.listFiles();

        if (files == null)
            throw new RuntimeException("获取文件失败");

        for (File file : files) {
            String newFilename = getNewFilename(file);
            String newFilePath = file.getParent() + "\\" + newFilename;
            if (!file.renameTo(new File(newFilePath)))
                System.out.println("重命名" + file.getName() + "失败");
        }
    }

    private String getNewFilename(File file) {
        if (file == null)
            return "";

        String oldName = file.getName(); // 获取旧名字
        String[] strings = oldName.split(oldSeparator); // 获取分割后的数组

        StringBuilder newName = new StringBuilder();
        for (String i : strings) {
            newName.append(i).append(newSeparator);
        }
        if (!"".equals(newSeparator))
            newName.deleteCharAt(newName.length() - 1);

        return newName.toString();
    }

    private String swapFilename(File file) {
        if (file == null)
            return "";

        String oldName = file.getName(); // 获取旧名字
        String[] strings = oldName.split(oldSeparator); // 获取分割后的数组


        StringBuilder newName = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            newName.append(strings[i]).append(newSeparator);
        }

        if (!"".equals(newSeparator))
            newName.deleteCharAt(newName.length() - 1);
        return newName.toString();
    }
}
