package com.ait.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dto.EmployeeDto;
import com.ait.model.EmployeeEntity;
import com.ait.repository.EmployeeRepository;
import com.ait.service.EmployeeService;
import com.ait.email.EmailService;
import com.ait.uitl.EmployeeNotFoundExaception;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	@Autowired
	private EmailService emailService;

	@Override
	@Transactional
	public EmployeeDto registerEmployee(EmployeeDto dto) {
		
		String htmlContent="<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>\r\n"
				+ "<html xmlns=“https://www.w3.org/1999/xhtml” xmlns:v=“urn:schemas-microsoft-com:vml” xmlns:o=“urn:schemas-microsoft-com:office:office”><head>\r\n"
				+ "<!—[if gte mso 9]><xml>\r\n"
				+ "<o:OfficeDocumentSettings>\r\n"
				+ "<o:AllowPNG/>\r\n"
				+ "<o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
				+ "</o:OfficeDocumentSettings>\r\n"
				+ "</xml><![endif]—>\r\n"
				+ "<title>Christmas Email template</title>\r\n"
				+ "<meta http–equiv=“Content-Type” content=“text/html; charset=utf-8”>\r\n"
				+ "<meta http–equiv=“X-UA-Compatible” content=“IE=edge”>\r\n"
				+ "<meta name=“viewport” content=“width=device-width, initial-scale=1.0 “>\r\n"
				+ "<meta name=“format-detection” content=“telephone=no”>\r\n"
				+ "<!—[if !mso]><!—>\r\n"
				+ "<link href=“https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800” rel=“stylesheet”>\r\n"
				+ "<!—<![endif]—>\r\n"
				+ "<style type=”text/css”>\r\n"
				+ "body {\r\n"
				+ "margin: 0 !important;\r\n"
				+ "padding: 0 !important;\r\n"
				+ "-webkit-text-size-adjust: 100% !important;\r\n"
				+ "-ms-text-size-adjust: 100% !important;\r\n"
				+ "-webkit-font-smoothing: antialiased !important;\r\n"
				+ "}\r\n"
				+ "img {\r\n"
				+ "border: 0 !important;\r\n"
				+ "outline: none !important;\r\n"
				+ "}\r\n"
				+ "p {\r\n"
				+ "Margin: 0px !important;\r\n"
				+ "Padding: 0px !important;\r\n"
				+ "}\r\n"
				+ "table {\r\n"
				+ "border-collapse: collapse;\r\n"
				+ "mso-table-lspace: 0px;\r\n"
				+ "mso-table-rspace: 0px;\r\n"
				+ "}\r\n"
				+ "td, a, span {\r\n"
				+ "border-collapse: collapse;\r\n"
				+ "mso-line-height-rule: exactly;\r\n"
				+ "}\r\n"
				+ ".ExternalClass * {\r\n"
				+ "line-height: 100%;\r\n"
				+ "}\r\n"
				+ ".em_defaultlink a {\r\n"
				+ "color: inherit !important;\r\n"
				+ "text-decoration: none !important;\r\n"
				+ "}\r\n"
				+ "span.MsoHyperlink {\r\n"
				+ "mso-style-priority: 99;\r\n"
				+ "color: inherit;\r\n"
				+ "}\r\n"
				+ "span.MsoHyperlinkFollowed {\r\n"
				+ "mso-style-priority: 99;\r\n"
				+ "color: inherit;\r\n"
				+ "}\r\n"
				+ "@media only screen and (min-width:481px) and (max-width:699px) {\r\n"
				+ ".em_main_table {\r\n"
				+ "width: 100% !important;\r\n"
				+ "}\r\n"
				+ ".em_wrapper {\r\n"
				+ "width: 100% !important;\r\n"
				+ "}\r\n"
				+ ".em_hide {\r\n"
				+ "display: none !important;\r\n"
				+ "}\r\n"
				+ ".em_img {\r\n"
				+ "width: 100% !important;\r\n"
				+ "height: auto !important;\r\n"
				+ "}\r\n"
				+ ".em_h20 {\r\n"
				+ "height: 20px !important;\r\n"
				+ "}\r\n"
				+ ".em_padd {\r\n"
				+ "padding: 20px 10px !important;\r\n"
				+ "}\r\n"
				+ "}\r\n"
				+ "@media screen and (max-width: 480px) {\r\n"
				+ ".em_main_table {\r\n"
				+ "width: 100% !important;\r\n"
				+ "}\r\n"
				+ ".em_wrapper {\r\n"
				+ "width: 100% !important;\r\n"
				+ "}\r\n"
				+ ".em_hide {\r\n"
				+ "display: none !important;\r\n"
				+ "}\r\n"
				+ ".em_img {\r\n"
				+ "width: 100% !important;\r\n"
				+ "height: auto !important;\r\n"
				+ "}\r\n"
				+ ".em_h20 {\r\n"
				+ "height: 20px !important;\r\n"
				+ "}\r\n"
				+ ".em_padd {\r\n"
				+ "padding: 20px 10px !important;\r\n"
				+ "}\r\n"
				+ ".em_text1 {\r\n"
				+ "font-size: 16px !important;\r\n"
				+ "line-height: 24px !important;\r\n"
				+ "}\r\n"
				+ "u + .em_body .em_full_wrap {\r\n"
				+ "width: 100% !important;\r\n"
				+ "width: 100vw !important;\r\n"
				+ "}\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ " \r\n"
				+ "<body class=“em_body” style=“margin:0px; padding:0px;” bgcolor=“#efefef”>\r\n"
				+ "<table class=“em_full_wrap” valign=“top” width=“100%” cellspacing=“0” cellpadding=“0” border=“0” bgcolor=“#efefef” align=“center”>\r\n"
				+ "<tbody><tr>\r\n"
				+ "<td valign=“top” align=“center”><table class=“em_main_table” style=“width:700px;” width=“700” cellspacing=“0” cellpadding=“0” border=“0” align=“center”>\r\n"
				+ "<!—Header section—>\r\n"
				+ "<tbody><tr>\r\n"
				+ "<td style=“padding:15px;” class=“em_padd” valign=“top” bgcolor=“#f6f7f8” align=“center”><table width=“100%” cellspacing=“0” cellpadding=“0” border=“0” align=“center”>\r\n"
				+ "<tbody><tr>\r\n"
				+ "<td style=“font-family:’Open Sans’, Arial, sans-serif; font-size:12px; line-height:15px; color:#0d1121;” valign=“top” align=“center”>Test Email Sample | <a href=“#” target=“_blank” style=“color:#0d1121; text-decoration:underline;”>View Online</a></td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody></table></td>\r\n"
				+ "</tr>\r\n"
				+ "<!—//Header section–>\r\n"
				+ "<!—Banner section—>\r\n"
				+ "<tr>\r\n"
				+ "<td valign=“top” align=“center”><table width=“100%” cellspacing=“0” cellpadding=“0” border=“0” align=“center”>\r\n"
				+ "<tbody><tr>\r\n"
				+ "<td valign=“top” align=“center”><img class=“em_img” alt=“merry Christmas” style=“display:block; font-family:Arial, sans-serif; font-size:30px; line-height:34px; color:#000000; max-width:700px;” src=“images/05be8b57-6b90-4ebd-ba17-4014c79f2e4b.jpg” width=“700” border=“0” height=“345”></td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody></table></td>\r\n"
				+ "</tr>\r\n"
				+ "<!—//Banner section–>\r\n"
				+ "<!—Content Text Section—>\r\n"
				+ "<tr>\r\n"
				+ "<td style=“padding:35px 70px 30px;” class=“em_padd” valign=“top” bgcolor=“#0d1121” align=“center”><table width=“100%” cellspacing=“0” cellpadding=“0” border=“0” align=“center”>\r\n"
				+ "<tbody><tr>\r\n"
				+ "<td style=“font-family:’Open Sans’, Arial, sans-serif; font-size:16px; line-height:30px; color:#ffffff;” valign=“top” align=“center”>This is a sample email which shall be accommodated in a single paragraph</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "<td style=“font-size:0px; line-height:0px; height:15px;” height=“15”> </td>\r\n"
				+ "<!——this is space of 15px to separate two paragraphs ——>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "<td style=“font-family:’Open Sans’, Arial, sans-serif; font-size:18px; line-height:22px; color:#fbeb59; letter-spacing:2px; padding-bottom:12px;” valign=“top” align=“center”>This is paragraph 2 of font size 18px and #fbeb59 font color with a line spacing of 15px</td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "<td class=“em_h20” style=“font-size:0px; line-height:0px; height:25px;” height=“25”> </td>\r\n"
				+ "<!——this is space of 25px to separate two paragraphs ——>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "<td style=“font-family:’Open Sans’, Arial, sans-serif; font-size:18px; line-height:22px; color:#fbeb59; text-transform:uppercase; letter-spacing:2px; padding-bottom:12px;” valign=“top” align=“center”> This is paragraph 3 of font size 18px and #fbeb59 font color with a line spacing of 25px and Uppercase</td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody></table></td>\r\n"
				+ "</tr>\r\n"
				+ " \r\n"
				+ "<!—//Content Text Section–>\r\n"
				+ "<!—Footer Section—>\r\n"
				+ "<tr>\r\n"
				+ "<td style=“padding:38px 30px;” class=“em_padd” valign=“top” bgcolor=“#f6f7f8” align=“center”><table width=“100%” cellspacing=“0” cellpadding=“0” border=“0” align=“center”>\r\n"
				+ "<tbody><tr>\r\n"
				+ "<td style=“padding-bottom:16px;” valign=“top” align=“center”><table cellspacing=“0” cellpadding=“0” border=“0” align=“center”>\r\n"
				+ "<tbody><tr>\r\n"
				+ "<td valign=“top” align=“center”><a href=“#” target=“_blank” style=“text-decoration:none;”><img src=“images/fb.png” alt=“fb” style=“display:block; font-family:Arial, sans-serif; font-size:14px; line-height:14px; color:#ffffff; max-width:26px;” width=“26” border=“0” height=“26”></a></td>\r\n"
				+ "<td style=“width:6px;” width=“6”> </td>\r\n"
				+ "<td valign=“top” align=“center”><a href=“#” target=“_blank” style=“text-decoration:none;”><img src=“images/tw.png” alt=“tw” style=“display:block; font-family:Arial, sans-serif; font-size:14px; line-height:14px; color:#ffffff; max-width:27px;” width=“27” border=“0” height=“26”></a></td>\r\n"
				+ "<td style=“width:6px;” width=“6”> </td>\r\n"
				+ "<td valign=“top” align=“center”><a href=“#” target=“_blank” style=“text-decoration:none;”><img src=“images/yt.png” alt=“yt” style=“display:block; font-family:Arial, sans-serif; font-size:14px; line-height:14px; color:#ffffff; max-width:26px;” width=“26” border=“0” height=“26”></a></td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody></table></td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "<td style=“font-family:’Open Sans’, Arial, sans-serif; font-size:11px; line-height:18px; color:#999999;” valign=“top” align=“center”><a href=“#” target=“_blank” style=“color:#999999; text-decoration:underline;”>PRIVACY STATEMENT</a> | <a href=“#” target=“_blank” style=“color:#999999; text-decoration:underline;”>TERMS OF SERVICE</a> | <a href=“#” target=“_blank” style=“color:#999999; text-decoration:underline;”>RETURNS</a><br>\r\n"
				+ "© 2017 Companyname. All Rights Reserved.<br>\r\n"
				+ "If you do not wish to receive any further emails from us, please <a href=“#” target=“_blank” style=“text-decoration:none; color:#999999;”>unsubscribe</a></td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody></table></td>\r\n"
				+ "</tr>\r\n"
				+ "<tr>\r\n"
				+ "<td class=“em_hide” style=“line-height:1px;min-width:700px;background-color:#ffffff;”><img alt=“” src=“images/spacer.gif” style=“max-height:1px; min-height:1px; display:block; width:700px; min-width:700px;” width=“700” border=“0” height=“1”></td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody></table></td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody></table>\r\n"
				+ "<div class=“em_hide” style=“white-space: nowrap; display: none; font-size:0px; line-height:0px;”>                           </div>\r\n"
				+ "</body></html>";
		
		
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getEmpId() > 0) {
			entity.setId(dto.getEmpId());
		}
		EmployeeEntity save = empRepository.save(entity);
		/**
		 * emailService.sendEmail(entity.getEmail(), "User Registered Sucessfully....!!!",
				   "user:" +save.getFirstName()+"is registered sucessfully and id is :"+save.getId()+""
				   		+ "");
		 */
		emailService.sendHtmlEmail(entity.getEmail(), "User Registered Sucessfully....!!!", 
				htmlContent,
				"C:\\Users\\shaik\\Downloads\\car.jpg");
		 
		dto.setEmpId(save.getId());
		BeanUtils.copyProperties(save, dto);
		return dto;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmployee(long id) {
		try {
			empRepository.deleteById(id);
		} catch (Exception e) {
			throw new EmployeeNotFoundExaception("employee not exist in database");
		}
		return false;
	}

	@Override
	public List<EmployeeDto> fetchAllEmployee() {
		List<EmployeeDto> listEmployee = new ArrayList<>();

		List<EmployeeEntity> all = empRepository.findAll();

		all.forEach(data -> {
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(data, dto);
			dto.setEmpId(data.getId());
			listEmployee.add(dto);
		});

		return listEmployee;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		EmployeeDto dto = new EmployeeDto();
		Optional<EmployeeEntity> employee = empRepository.findById(id);
		EmployeeEntity employeeEntity = employee.get();
		BeanUtils.copyProperties(employeeEntity, dto);
		dto.setEmpId(employeeEntity.getId());
		return dto;
	}

	@Override
	public String loginEmployee(String email, String password) {
		Optional<EmployeeEntity> byEmailAndPassword = empRepository.findByEmailAndPassword(email, password);
		if (byEmailAndPassword.isPresent()) {
			Long id = byEmailAndPassword.get().getId();
			return String.valueOf(id);
		} else {
			return "0";
		}

	}

	@Override
	public void handleHttpSession(Long id, HttpSession session) {
		session.setAttribute("userid", id);

	}

}
