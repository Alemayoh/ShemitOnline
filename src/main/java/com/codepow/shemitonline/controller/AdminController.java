package com.codepow.shemitonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
