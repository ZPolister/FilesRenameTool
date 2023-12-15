public class Main {
    public static void main(String[] args) {
        final String oldSep = "-"; // 旧分隔符
        final String newSep = "_"; // 新分隔符
        final String workPath = "C:\\Users\\Polister\\Desktop\\22计算机5班_大物作业_第九章\\第九章"; // 工作目录
        FilesRenameTools filesRenameTools = new FilesRenameTools(oldSep, newSep, workPath);
        filesRenameTools.startRename();
    }
}
