package com.codepow.shemitonline.controller;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import com.codepow.shemitonline.dao.OrderDAO;
import com.codepow.shemitonline.dao.ProductDAO;
import com.codepow.shemitonline.entity.Product;
import com.codepow.shemitonline.form.ProductForm;
import com.codepow.shemitonline.model.OrderDetailInfo;
import com.codepow.shemitonline.model.OrderInfo;
import com.codepow.shemitonline.pagination.PaginationResult;
import com.codepow.shemitonline.validator.ProductFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class AdminController {
	
	// POST: Save product
	   @RequestMapping(value = { "/admin/product" }, method = RequestMethod.POST)
	   public String productSave(Model model, //
	         @ModelAttribute("productForm") @Validated ProductForm productForm, //
	         BindingResult result, //
	         final RedirectAttributes redirectAttributes) {
	 
	      if (result.hasErrors()) {
	         return "product";
	      }
	      try {
	         productDAO.save(productForm);
	      } catch (Exception e) {
	         Throwable rootCause = ExceptionUtils.getRootCause(e);
	         String message = rootCause.getMessage();
	         model.addAttribute("errorMessage", message);
	         // Show product form.
	         return "product";
	      }
	 
	      return "redirect:/productList";
	   }

}
