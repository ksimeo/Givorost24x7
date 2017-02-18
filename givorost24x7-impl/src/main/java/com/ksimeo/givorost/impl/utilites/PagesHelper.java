package com.ksimeo.givorost.impl.utilites;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo. Created on 29.01.2017 at 7:07 for "givorost24x7" project.
 * @version 1.0
 * @since 1.0
 */
public class PagesHelper {

    public final static int maxRowsCountOnPage = 5;


    public static PageInfo getRowNumbers(int pageNumb, int rowsCount) {

        System.out.println("rowCount: " + rowsCount);
        if (rowsCount < 1) throw new IllegalArgumentException("Illegal statement of variable \"rowsCount\"!");
        int maxPageNumb = getPageCount(rowsCount);
        System.out.println("pageNumb: " + pageNumb);
        System.out.println("maxPageNumb: " + maxPageNumb);
        if (pageNumb < 1 || pageNumb > maxPageNumb)
            throw new IllegalArgumentException("Illegal statement of variable \"pageNumb\"!");
        int maxPos = rowsCount - ((pageNumb - 1)* maxRowsCountOnPage);
        int minPos = maxPos - (maxRowsCountOnPage - 1);
        if (maxPos > rowsCount) maxPos = rowsCount;
        if (minPos > rowsCount) minPos = rowsCount;
        if (minPos < 1) minPos = 1;
        boolean isLastPage = (pageNumb == maxPageNumb);

        return new PagesHelper().new PageInfo(minPos, maxPos, isLastPage);
    }

    public static int getPageCount(int count) {

        int pageNumb = count / maxRowsCountOnPage;
        if (count % maxRowsCountOnPage != 0) pageNumb++;
        return pageNumb;
    }

    public static List<String> getPagination(int currPage, int pageCount, int maxShowedNumbOnPages) {
        if (currPage < 1 || currPage > pageCount) throw new IllegalArgumentException("state of variable currPage is " +
                "illegal!");
        if (pageCount < 1) throw new IllegalArgumentException("state of variable pageCount is illegal!");
        if (maxShowedNumbOnPages <= 1) throw new IllegalArgumentException("state of variable maxShowedNumbOnPages is " +
                "illegal!");

        int maxPageNumb = currPage + 4;
        int minPageNumb = currPage - 5;

            if (minPageNumb < 1) {
                minPageNumb = 1;
                maxPageNumb = maxShowedNumbOnPages;
            }
            if (maxPageNumb > pageCount) {
                maxPageNumb = pageCount;
                if (maxPageNumb - minPageNumb < maxShowedNumbOnPages) {
                    minPageNumb = maxPageNumb - (maxShowedNumbOnPages - 1);
                    if (minPageNumb < 1) minPageNumb = 1;
                }
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

        java.sql.Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yy HH:mm:ss");
        String date2 = dateFormat.format(date);
        System.out.println(date2);

//        Calendar calendar = new GregorianCalendar();
//        System.out.println(calendar);
//        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yy HH:mm:ss");
//        String date = dateFormat.format(calendar);
//
//        LocalDateTime cal = LocalDateTime.parse(date);
//        Calendar cal1 = Calendar.getInstance();
//        dateFormat.getCalendar();
//
//
//        try {
//            Date date1 = dateFormat.parse(date);
//        } catch (Exception e) {
//
//        }
//
//        Calendar calendar1 = new GregorianCalendar();
//
//        System.out.println(date);




//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yy/HH:mm");
//        String data = localDateTime.format(format);
//        System.out.println(data);
    }
}
