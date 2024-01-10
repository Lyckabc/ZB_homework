/******************************************************
 **                                                  **
 **        99_ZBTest                                 **
 **        M1_makePager                    **
 **        Made by Toji                              **
 **        1/11/2024  2:35 AM                       **
 **        https://github.com/lyckabc                **
 **                                                  **
 ******************************************************/
package M1_makePager;

import java.util.*;
import java.io.*;

public class M1_makePager {
    public static void main(String[] args) {
        Random rand = new Random();
        int totalPosts = rand.nextInt(200) + 127;
        int postsPerPage = 10; // 한 페이지당 게시글 수
        int pageBlock = 10; // 페이지네비게이션 블록 수

        int totalPages = (int) Math.ceil((double) totalPosts / postsPerPage);
        int currentPage = rand.nextInt(totalPages) + 2;
        int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
        int endPage = Math.min(startPage + pageBlock - 1, totalPages);

        try (FileWriter writer = new FileWriter("pager.html")) {
            writer.write("<html><head><style>.on { color: red; }</style></head><body><nav><ul style='list-style: none; display: flex;'>");

            // 처음과 이전 링크
            writer.write("<li><a href='#'>[처음]</a></li>");
            writer.write("<li>&nbsp;</li>");
            writer.write("<li><a href='#'>[이전]</a></li>");
            writer.write("<li>&nbsp;</li>");

            // 페이지 번호 링크
            for (int i = startPage; i <= endPage; i++) {
                if (i == currentPage) {
                    writer.write("<li><a href='#' class='on'>" + i + "</a></li>");
                } else {
                    writer.write("<li><a href='#'>" + i + "</a></li>");
                }
                writer.write("<li>&nbsp;</li>");
            }

            // 다음과 마지막 링크
            writer.write("<li><a href='#'>[다음]</a></li>");
            writer.write("<li>&nbsp;</li>");
            writer.write("<li><a href='#'>[마지막]</a></li>");

            writer.write("</ul></nav></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
