package com.example.bookEcommerce.controller

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.model.Role
import com.example.bookEcommerce.service.RoleService
import com.example.bookEcommerce.utils.constants.Constants
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("${Constants.MAIN_URL}role")
class RoleController (private val roleService: RoleService){
    @GetMapping
    fun index() : ObjectResponse<List<Role>> {
        return roleService.index()
    }
    @GetMapping("/{id}")
    fun show(@PathVariable("id") id :Int) : ObjectResponse<Role> {
        return roleService.show(id)
    }
    @PostMapping("/create")
    fun create(@RequestBody newRole : Role): MessageResponse {
        return roleService.create(newRole)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id :Int) : MessageResponse {
        return roleService.deleteById(id)
    }
    @PutMapping("/put/{id}")
    fun updateById(@PathVariable("id") id :Int, @RequestBody updatedRole : Role): MessageResponse {
        return roleService.updateById(id = id , updatedRole = updatedRole)
    }
}