public class Main {
    public static void main(String[] args) {
        final String oldSep = "-"; // 旧分隔符
        final String newSep = ""; // 新分隔符
        final String workPath = ""; // 工作目录
        FilesRenameTools filesRenameTools = new FilesRenameTools(oldSep, newSep, workPath);
        filesRenameTools.startRename();
    }
}
