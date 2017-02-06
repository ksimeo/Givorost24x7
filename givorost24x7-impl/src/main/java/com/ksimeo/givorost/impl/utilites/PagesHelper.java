package com.ksimeo.givorost.impl.utilites;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 29.01.2017 at 7:07 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class PagesHelper {

    public static PageInfo getRowNumbers(int pageNumb, int numb, int rowCount) {
        int from;
        int to;
        boolean isLastPage = false;
//        int numb = ordDao.getCount();
        int maxFullPage = numb / rowCount;
        if (pageNumb > maxFullPage) {
            pageNumb = maxFullPage;
            isLastPage = true;
        }
        if (pageNumb > 0) {
            to = numb - ((pageNumb - 1) * rowCount);
            from = to - (rowCount - 1);
        } else {
            pageNumb = 1;
            to = numb - ((pageNumb - 1) * rowCount);
            from = to - (rowCount - 1);
        }
        return new PagesHelper().new PageInfo(from, to, isLastPage);
    }

    public static int getPageCount(int count, int maxRowsNumber) {

        int pageNumb = count / maxRowsNumber;
        if (count % maxRowsNumber != 0) pageNumb++;
        return pageNumb;
    }

    public static List<String> getPagination(int currPageNumb, int pagesCount, int maxPagesOnPage) {

        final int approachToBondsCoeff = 4;
        int minPageNumb = currPageNumb - (pagesCount - approachToBondsCoeff);
        int maxPageNumb = currPageNumb + approachToBondsCoeff;

        int topDelta = maxPageNumb - currPageNumb;

        if (topDelta < approachToBondsCoeff) maxPageNumb = currPageNumb + approachToBondsCoeff;

        if (maxPageNumb - minPageNumb > maxPagesOnPage) {
            minPageNumb = maxPageNumb - maxPagesOnPage;
        }

//        if (maxPageNumb > pagesCount) {
//            maxPageNumb = pagesCount;
//        }

//        if (maxPageNumb - minPageNumb < maxPagesOnPage + 1) {
//            minPageNumb = maxPageNumb - (maxPagesOnPage - 1);
//        }
//
//        if (minPageNumb < 1) {
//            minPageNumb = 1;
//            maxPageNumb = minPageNumb + (maxPagesOnPage - 1);
//        }

        if (maxPageNumb > pagesCount) {
            maxPageNumb = pagesCount;
        }

        if (maxPageNumb - minPageNumb < maxPagesOnPage + 1) {
            minPageNumb = maxPageNumb - (maxPagesOnPage - 1);
        }

        if (minPageNumb < 1) {
            minPageNumb = 1;
            maxPageNumb = minPageNumb + (maxPagesOnPage - 1);
        }

        List<String> toSend = new ArrayList<>(maxPageNumb - minPageNumb);

        for (int n = minPageNumb; n <= maxPageNumb; n++) {
            toSend.add(Integer.toString(n));
        }
        return toSend;
    }

    public class PageInfo {
        public final int from;
        public final int to;
        public final boolean isLast;

        public PageInfo(int from, int to, boolean isLast) {
            this.from = from;
            this.to = to;
            this.isLast = isLast;
        }
    }

    public static void main(String[] args) {

        List<String> arrays = PagesHelper.getPagination(7, 14, 10);
        System.out.println(arrays);
    }
}
