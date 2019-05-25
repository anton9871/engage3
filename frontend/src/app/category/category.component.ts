import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories:any

  category = {
    name: '',
    parent_id: ''
  }

  showEditFormBoolean = false
  editCategory = {
    id: '',
    name: '',
    parent_id: ''
  }
  

  constructor(private _httpService: HttpService, private _router:Router) { }

  ngOnInit() {
    this.getAllCategories()
  }

  getAllCategories(){
    this._httpService.getCategories().subscribe(res=>{
      this.categories = res
      console.log(res)
    })
  }

  addNewCategory(){
    this._httpService.createCategory(this.category).subscribe(res=>{
      console.log(res)
      this.getAllCategories()

    })
  }

  deleteCategory(id){
    this._httpService.deleteCategory(id).subscribe(res=>{
      this.getAllCategories()
    })
  }

  // show the edit form and pre-populate existing data
  showEditForm(category){
    this.showEditFormBoolean = true
    this.editCategory.id = category.id
    this.editCategory.name = category.name
    this.editCategory.parent_id = category.parent_id
  }

  updateCategory(){
    this._httpService.updateCategory(this.editCategory.id, this.editCategory).subscribe(res=>{
      console.log(res)
      this.getAllCategories()
      this.showEditFormBoolean = false
    })
  }

  openProducts(id){
    this._router.navigate(['products', id])
  }

}
