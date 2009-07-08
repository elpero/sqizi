package no.sqizi.webapp.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InOrder;
import org.mockito.internal.verification.api.VerificationMode;
import org.mockito.internal.verification.VerificationModeFactory;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import no.sqizi.webapp.dao.ArticlesDao;
import no.sqizi.webapp.dao.ImageDao;
import no.sqizi.webapp.support.PropertiesSupplier;
import no.sqizi.webapp.domain.ArticleImage;

import javax.imageio.ImageIO;
import java.net.URL;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jul 1, 2009
 * Time: 8:52:15 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class ImageServiceImplTest {

    @Mock
    ImageDao dao;

    @Mock
    PropertiesSupplier appProps;

    ImageServiceImpl service;

    @Before
    public void setUp() {
        service = new ImageServiceImpl();
        service.setAppProps(appProps);
        service.setArticleDao(dao);
    }

    @Test
    public void testSaveArticleImage() throws IOException {


        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(
                ImageIO.read(new URL("http://www.google.pl/intl/en_com/images/logo_plain.png")),
                "png",
                byteArrayOutputStream);

        when(service.getAppProps().getProperty("images.directory")).thenReturn("/tmp/");

        ArticleImage i = new ArticleImage("image.png", byteArrayOutputStream.toByteArray(), 1L);

        service.saveArticleImage(i);


        Assert.assertTrue(new File("/tmp/1/image.png").exists());
        Assert.assertTrue(new File("/tmp/1/image_thumb.png").exists());

        InOrder inOrder = Mockito.inOrder(dao);
        inOrder.verify(dao).saveArticleImage(i);
        inOrder.verify(dao).addArticleReferenceToImage(i);
    }
}
