import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { }

  getCategories(){
    return this._http.get('http://localhost:8080/category')
  }

  getCategory(id){
    return this._http.get('http://localhost:8080/category/'+id)
  }
  
  createCategory(category){
    return this._http.post('http://localhost:8080/category', category)
  }
  
  updateCategory(id, category){
    return this._http.put('http://localhost:8080/category/'+id, category)
  }
  
  deleteCategory(id){
    return this._http.delete('http://localhost:8080/category/'+id)
  }

  getProductsFromCategory(id){
    return this._http.get('http://localhost:8080/products/'+id)
  }

  getProducts(){
    return this._http.get('http://localhost:8080/products')
  }

  getProduct(id){
    return this._http.get('http://localhost:8080/product/'+id)
  }

  createProduct(product){
    return this._http.post('http://localhost:8080/product', product)
  }

  updateProduct(id, product){
    return this._http.put('http://localhost:8080/product/'+id, product)
  }

  deleteProduct(id){
    return this._http.delete('http://localhost:8080/product/'+id)
  }


}
