
import com.example.KiemThuNangCaoBuoi4.enitty.BaiHat;
import com.example.KiemThuNangCaoBuoi4.service.BaiHatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;
public class Bai4 {
    BaiHatService service;

    @BeforeEach
    public void setup() {
        service = new BaiHatService();
    }

    @Test
    public void testAddValid() {
        BaiHat bh = new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180);
        service.addBaiHat(bh);
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testAddDuplicateID() {
        BaiHat bh1 = new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180);
        BaiHat bh2 = new BaiHat("1", "Bai Hat 2", "Ca Si 2", 200);
        service.addBaiHat(bh1);
        service.addBaiHat(bh2);
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test
    public void updateValid() {
        BaiHat bh1 = new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180);
        service.addBaiHat(bh1);

        BaiHat bh2 = new BaiHat("1", "Bai Hat Moi", "Ca Si Moi", 200);
        service.updateBaiHat(bh2, "1");

        Assert.assertEquals("Bai Hat Moi", service.getAll().get(0).getTen());
    }

    @Test
    public void updateNonExisting() {
        BaiHat bh = new BaiHat("1", "Bai Hat Moi", "Ca Si Moi", 200);
        service.updateBaiHat(bh, "2");
        Assert.assertEquals(0, service.getAll().size());
    }

    @Test
    public void deleteValid() {
        BaiHat bh = new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180);
        service.addBaiHat(bh);
        service.deleteBaiHat("1");
        Assert.assertEquals(0, service.getAll().size());
    }

    @Test
    public void deleteInvalid() {
        BaiHat bh = new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180);
        service.addBaiHat(bh);
        service.deleteBaiHat("2");
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test
    public void searchValid() {
        BaiHat bh = new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180);
        service.addBaiHat(bh);
        BaiHat found = service.searchBaiHat("1");
        Assert.assertNotNull(found);
        Assert.assertEquals("1", found.getId());
    }

    @Test
    public void searchInvalid() {
        BaiHat found = service.searchBaiHat("99");
        Assert.assertNull(found);
    }

    @Test
    public void testEmptyListInitially() {
        Assert.assertEquals(0, service.getAll().size());
    }

    @Test
    public void testAddMultipleSongs() {
        service.addBaiHat(new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180));
        service.addBaiHat(new BaiHat("2", "Bai Hat 2", "Ca Si 2", 200));
        Assert.assertEquals(2, service.getAll().size());
    }

    @Test
    public void testDeleteAllSongs() {
        service.addBaiHat(new BaiHat("1", "Bai Hat 1", "Ca Si 1", 180));
        service.addBaiHat(new BaiHat("2", "Bai Hat 2", "Ca Si 2", 200));
        service.deleteBaiHat("1");
        service.deleteBaiHat("2");
        Assert.assertEquals(0, service.getAll().size());
    }

    @Test
    public void testSearchSongWithSpecialCharacters() {
        BaiHat bh = new BaiHat("1", "Bài hát @#", "Ca Si !@", 180);
        service.addBaiHat(bh);
        BaiHat found = service.searchBaiHat("1");
        Assert.assertNotNull(found);
        Assert.assertEquals("Bài hát @#", found.getTen());
    }

    @Test
    public void updateWithEmptyName() {
        BaiHat bh = new BaiHat("1", "", "Ca Si 1", 180);
        service.updateBaiHat(bh, "1");
        BaiHat updated = service.searchBaiHat("1");
        Assert.assertNull(updated);
    }

    @Test
    public void updateWithEmptySinger() {
        BaiHat bh = new BaiHat("1", "Bai Hat 1", "", 180);
        service.updateBaiHat(bh, "1");
        BaiHat updated = service.searchBaiHat("1");
        Assert.assertNull(updated);
    }

    @Test
    public void updateWithNegativeDuration() {
        BaiHat bh = new BaiHat("1", "Bai Hat 1", "Ca Si 1", -10);
        service.updateBaiHat(bh, "1");
        BaiHat updated = service.searchBaiHat("1");
        Assert.assertNull(updated);
    }
}
