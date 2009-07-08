package no.sqizi.webapp.springmvc;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import no.sqizi.webapp.domain.ArticleImage;
import no.sqizi.webapp.services.ImageService;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 23, 2009
 * Time: 8:55:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/upload")
public class UploadServlet {
    private static final int MAX_FILE_SIZE = 2048 * 2048;
    private Logger log = Logger.getLogger(UploadServlet.class);

    @Autowired
    private ImageService service;

    public ImageService getService() {
        return service;
    }

    public void setService(ImageService service) {
        this.service = service;
    }

    @RequestMapping(method=RequestMethod.POST)
    public void handleUpload(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException {
        httpServletRequest.getContextPath();

        if (ServletFileUpload.isMultipartContent(httpServletRequest)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MAX_FILE_SIZE); // Upload files only into
														// memory
			factory.setRepository(null);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(MAX_FILE_SIZE); // Upload files only into memory
			List<FileItem> items = null;

			try {
				items = upload.parseRequest(httpServletRequest);
				String fileName = null;
				Long articleId = null;
				byte[] fileData = null;

				for (FileItem item : items) {
					if ((!item.isFormField())&&(item.isInMemory())) {
							fileData = item.get();
					}
				}

				if (fileName == null){
					fileName = httpServletRequest.getParameter("fileName");
				}

				if (articleId == null){
					articleId = Long.parseLong(httpServletRequest.getParameter("articleId"));
				}

                ArticleImage i = new ArticleImage(fileName, fileData, articleId);
                service.saveArticleImage(i);
			
			} catch (Throwable t) {
				log.error("Error when uploading media file", t);
				throw new ServletException("Error when uploading media file", t);
			}
		}
        
    }
    @RequestMapping(method=RequestMethod.GET)
    public void handleGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException {
        handleUpload(httpServletRequest, httpServletResponse);

    }


}
