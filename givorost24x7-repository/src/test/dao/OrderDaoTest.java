package dao;

import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.repository.dao.OrderDao;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class OrderDaoTest extends TestCase {

    private OrderDAO orderDao;

    private OrderDTO testFoo;

    private int testOrderId;

    @BeforeClass
    @Override
    public void setUp() {
        orderDao = new OrderDao();
        orderDao.saveOrUpdate(new OrderDTO("Алехин А.А.", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDao.saveOrUpdate(new OrderDTO("Курелец С.Р.", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDao.saveOrUpdate(new OrderDTO("Пивень Л.И.", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDao.saveOrUpdate(new OrderDTO("Юра Хилько", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDao.saveOrUpdate(new OrderDTO("Ярослав Прусенко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDao.saveOrUpdate(new OrderDTO("Ольга Крошка", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDao.saveOrUpdate(new OrderDTO("Игорь Крючков", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDao.saveOrUpdate(new OrderDTO("Паша Процько", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDao.saveOrUpdate(new OrderDTO("Наташа Михайлова", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDao.saveOrUpdate(new OrderDTO("Таня Кузьменко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDao.saveOrUpdate(new OrderDTO("Карбачин Саша", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDao.saveOrUpdate(new OrderDTO("Антон Чуйко", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDao.saveOrUpdate(new OrderDTO("Ян Аронович", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDao.saveOrUpdate(new OrderDTO("Сергей Поляков", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDao.saveOrUpdate(new OrderDTO("Миша Иванов", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDao.saveOrUpdate(new OrderDTO("Женя", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDao.saveOrUpdate(new OrderDTO("Н.В. Шатько", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDao.saveOrUpdate(new OrderDTO("Сергей Гострый", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDao.saveOrUpdate(new OrderDTO("Настя Никишкина", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDao.saveOrUpdate(new OrderDTO("Оксана Дьяченко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDao.saveOrUpdate(new OrderDTO("Оксана Кондрашева", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDao.saveOrUpdate(new OrderDTO("Лиля Прудченко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
    }

    @Test
    public void saveOrUpdateTest() throws Exception {
        testFoo = new OrderDTO("Абакумов А.В.", "+380674567890", "Продукт №1", "21/03/17", 98);
        testOrderId = orderDao.saveOrUpdate(testFoo);
        assertNotSame(testOrderId, 0);
    }

    @Test
    public void findOneTest() throws Exception {
        OrderDTO res = orderDao.findOne(testOrderId);
        assertNotNull(res);
        assertEquals(res, testFoo);
    }

    @Test
    public void findAllTest() throws Exception {
        List<OrderDTO> res = orderDao.findAll();
        assertNotNull(res);
    }

    @Test
    public void findSeveralTest() throws Exception {
        List<OrderDTO> res = orderDao.findSeveral(1, 8);
        assertNotNull(res);
    }

    @Test
    public void dropOneTest() throws Exception {
        orderDao.dropOne(testOrderId);
    }


    @AfterClass
    @Override
    public void tearDown() {
        orderDao.dropAll();
    }
}