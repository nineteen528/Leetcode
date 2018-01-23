package SJc;

/**
 * Created by SJC on 2018/1/20.
 */
public class Solu {
    public static boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
        for(int i = 0;i < board.length;i++){
            for(int j = 0 ;j < board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                StringBuilder sb = new StringBuilder();
//                sb.append(board[i][j]);
//                System.out.println(sb.toString().equals(word));
                if(DFS(i,j,sb,word,board,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean DFS(int i,int j,StringBuilder sb,String ss,char[][] board,boolean[][]visited){
        if(sb.toString().equals(ss)) {
            // System.out.println(122333);
            return true;
        }
        if(sb.length() == ss.length()) return false;
        if(!sb.toString().equals("") && !sb.toString().equals(ss.substring(0,sb.length()))) return false;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(visited[i][j]) return false;
        visited[i][j] = true;
        StringBuilder tmp = new StringBuilder(sb).append(board[i][j]);
        if(DFS(i - 1,j,tmp,ss,board,visited) || DFS(i + 1,j,tmp,ss,board,visited)
                || DFS(i,j - 1,tmp,ss,board,visited) || DFS(i,j + 1,tmp,ss,board,visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
    //better
    public static boolean exist2(char[][] board, String word) {
        if(board == null || word == null) return false;
        for(int i = 0;i < board.length;i++){
            for(int j = 0 ;j < board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                int number = 0;
//                System.out.println(sb.toString().equals(word));
                if(DFS2(i,j,number,word,board,visited)){
                    return true;
               }
            }
        }
        return false;
    }
    private static boolean DFS2(int i,int j,int num,String ss,char[][] board,boolean[][]visited){
        if(num == ss.length()) {
            //System.out.println(122333);
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != ss.charAt(num)) return false;
        if(visited[i][j]) return false;
        visited[i][j] = true;

        if(DFS2(i - 1,j,num + 1,ss,board,visited) || DFS2(i + 1,j,num +  1,ss,board,visited)
                || DFS2(i,j - 1,num + 1,ss,board,visited) || DFS2(i,j + 1,num + 1,ss,board,visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }



    public static void main(String[] args) {
        char[][] ch = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String s = "abcced";
        System.out.println(s);

        System.out.println(exist(ch,s));
    }
}
