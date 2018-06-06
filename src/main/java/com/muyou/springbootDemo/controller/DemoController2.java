package com.muyou.springbootDemo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.muyou.springbootDemo.domian.User;
import com.muyou.springbootDemo.service.DemoService;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;

@RestController
@RequestMapping("de")
public class DemoController2 {

	@Resource
	private DemoService demoService;

	@RequestMapping("demo")
	public String demo() {
		return "SpringBootDemo!!!";
	}

	@RequestMapping("add")
	public String add(User user) {
		User user2 = demoService.add(user);
		return (!"".equals(user2) && user2 != null) ? "添加成功" : "添加失败";
	}

	@RequestMapping("del")
	public String del(String id) {
		demoService.del(id);
		return "删除成功!";
	}

	@RequestMapping("modi")
	public String nodi(User user) {
		User user2 = demoService.modi(user);
		return (!"".equals(user2) && user2 != null) ? "修改成功" : "修改失败";
	}

	// 导出全部数据(数据量少时 比如: 少于20000条数据)
	@RequestMapping("downloadExcel")
	public void downloadExcel(HttpServletResponse res) throws IOException {
		long t1 = System.currentTimeMillis();
		// 默认的为application/json,而谷歌浏览器所期望的值应该是text/html
		res.setHeader("Content-type", "text/html");
		// 设置响应头 设置 导出的表的名称
		res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("个人信息表", "utf-8") + ".xlsx");
		// 设置响应数据编码格式
		res.setCharacterEncoding("utf-8");
		List<User> list = demoService.findAll();
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("个人基本信息", "个人"), User.class, list);
		workbook.write(res.getOutputStream());
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
	
		// 导入全部数据
		@RequestMapping("importData")
		public void importData(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws Exception {
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			// 下面的filepath 获取的是上传到tomcat 数据缓存目录中的位置
			// String filePath = request.getServletContext().getRealPath("uploads");
			// 这个filepath 是项目中的static 下的自定义文件存放目录
			String filePath = "src/main/resources/static/uploads";
			uploadFile(file.getBytes(), filePath, fileName);
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			params.setHeadRows(1);
			// params.setSheetNum(5);
			System.out.println(filePath);
			List<User> list = ExcelImportUtil.importExcel(new File(filePath + File.separator + fileName),User.class, params);
			System.out.println(list);
			demoService.save(list);
		}

		// 上传文件的保存
		public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
			File targetFile = new File(filePath);
			if (!targetFile.exists()) targetFile.mkdirs();
			FileOutputStream out = new FileOutputStream(filePath + File.separator + fileName);
			out.write(file);
			out.flush();
			out.close();
		}
}
