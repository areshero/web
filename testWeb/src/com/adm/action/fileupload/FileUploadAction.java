package com.adm.action.fileupload;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Show case File Upload example's action. <code>FileUploadAction</code>
 */
public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 5156288255337069381L;

	private String contentType;
	private File upload;
	private String fileName;
	private String caption;

	public String input() throws Exception {
		return SUCCESS;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getTargetFileName() {
		return targetFileName;
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName = targetFileName;
	}

	private String dir;// 保存文件路径属性

	private String targetFileName;// 保存文件名称属性

	private String generateFileName(String fileName) {

		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");

		String formatDate = format.format(new Date());

		int random = new Random().nextInt(10000);// 随即生成文件编号

		int position = fileName.lastIndexOf(".");// 得到文件名中"."的位置

		System.out.println(fileName);

		System.out.println(position);

		String extension = fileName.substring(position);// 得到文件的扩展名

		System.out.println(extension);

		return formatDate + random + extension;

	}

	public String upload() throws Exception {

		System.out.println(upload + " upload");

		String realPath = ServletActionContext.getRequest().getRealPath(
				"/upload");
		System.out.println("realpath " + realPath);
		String targetDirectory = realPath;

		targetFileName = generateFileName(fileName);// 生成保存文件的名称

		setDir(targetDirectory + "//" + targetFileName);// 保存文件的路径

		File target = new File(targetDirectory, targetFileName);// 建立一个目标文件

		FileUtils.copyFile(upload, target);// 将临时文件复制到目标文件
		// //基于myFile创建一个文件输入流
		// InputStream is = new FileInputStream(upload);
		//
		// // 设置上传文件目录
		// //String uploadPath =
		// ServletActionContext.getServletContext().getRealPath("/upload");
		//
		// // 设置目标文件
		// File toFile = new File("~/tomcatuploadfile");
		//
		// // 创建一个输出流
		// OutputStream os = new FileOutputStream(toFile);
		//
		// //设置缓存
		// byte[] buffer = new byte[1024];
		//
		// int length = 0;
		//
		// //读取myFile文件输出到toFile文件中
		// while ((length = is.read(buffer)) > 0) {
		// os.write(buffer, 0, length);
		// }
		// //关闭输入流
		// is.close();
		//
		// //关闭输出流
		// os.close();
		//
		//
		//
		// System.out.println("我哈哈哈哈哈哈");
		return SUCCESS;
	}

	// since we are using <s:file name="upload" .../> the file name will be
	// obtained through getter/setter of <file-tag-name>FileName
	public String getUploadFileName() {
		return fileName;
	}

	public void setUploadFileName(String fileName) {
		this.fileName = fileName;
	}

	// since we are using <s:file name="upload" ... /> the content type will be
	// obtained through getter/setter of <file-tag-name>ContentType
	public String getUploadContentType() {
		return contentType;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	// since we are using <s:file name="upload" ... /> the File itself will be
	// obtained through getter/setter of <file-tag-name>
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}
