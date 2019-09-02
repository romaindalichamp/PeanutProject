import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductsComponent } from './components/products/products.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './guards/auth.guard';
import { AddProductComponent } from './components/add-product/add-product.component';
import { EditProductComponent } from './components/edit-product/edit-product.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'products',
    pathMatch: 'full'
  },
  {
    path: 'products',
    canActivate: [AuthGuard],   //AuthGuard is using "canActivate" method, to check if the current user is connected before to redirect to products list
    component: ProductsComponent,
    data: { title: 'List of Products' }
  },
  {
    path: 'edit-product/:id',
    canActivate: [AuthGuard],
    component: EditProductComponent,
    data: { title: 'Edit Article' }
  },
  {
    path: 'addproduct',
    canActivate: [AuthGuard],
    component: AddProductComponent,
    data: { title: 'Add Product' }
  },
  {
    path: 'login',
    component: LoginComponent,
    data: { title: 'Login' }
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: { title: 'Register' }
  },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }