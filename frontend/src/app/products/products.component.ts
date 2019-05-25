import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  parameterID
  
  products:any
  categories:any

  categoryName
  categoryObject

  product = {
    name: '',
    category: {}
  }

  showEditFormBoolean = false
  editProduct = {
    id: '',
    name: '',
    category: {}
  }

  constructor(private _httpService: HttpService, private _router:Router, private _route:ActivatedRoute) { }

  ngOnInit() {
    this._route.params.subscribe((params: Params) => {
      this.parameterID = params['id']
      console.log(this.parameterID)
    })

    this.getProducts()
    this.getCategoryName()
    this.getAllCategories()

  }

  getProducts(){
    this._httpService.getProducts().subscribe(res =>{
    console.log(res)
    this.products = res
    })
  }


  getAllCategories(){
    this._httpService.getCategories().subscribe(res=>{
      this.categories = res
      console.log("Categories"+res)
    })
  }

  addNewProduct(){
    console.log("Product being created: "+this.product)
    this._httpService.createProduct(this.product).subscribe(res=>{
      console.log(res)
      this.getProducts()

    })
  }

  deleteProduct(id){
    this._httpService.deleteProduct(id).subscribe(res=>{
      this.getProducts()
    })
  }

  // show the edit form and pre-populate existing data
  showEditForm(product){
    this.showEditFormBoolean = true
    this.editProduct.id = product.id
    this.editProduct.name = product.name
  }

  updateProduct(){
    console.log("EDITPRODUCT"+this.editProduct.name)
    console.log("EDITPRODUCT"+this.editProduct.id)
    this._httpService.updateProduct(this.editProduct.id, this.editProduct).subscribe(res=>{
      console.log(res)
      this.getProducts()
      this.showEditFormBoolean = false
    })
  }

  getCategoryName(){
    this._httpService.getCategory(this.parameterID).subscribe(res =>{
      this.categoryName =  res['name']
      this.product.category = res
      this.editProduct.category = res
    })
  }



}
