import api from './api';
import { authHeader } from '../helpers/auth-header';

const getAllProducts = () => {
  return api.get('/products', { headers: authHeader() });
};

const getProductById = async (id) => {
  try {
    const response = await api.get('/products/{id}', { headers: authHeader() });
    return response.data;
  } catch (error) {
    console.error('Error fetching product:', error);
    throw error; // Re-throw the error for handling in the calling component
  }
};


const createProduct = (product) => {
  return api.post('/products/admin/post', product, { headers: authHeader() });
}

const deleteProduct = async (id) => {
  try {
    await api.delete('/products/{id}', id, { headers: authHeader() });
    return { message: 'Produit supprimé avec succès' };
  } catch (error) {
    console.error('Error deleting product:', error);
    throw error; 
  }
};

export const productService = { getAllProducts, getProductById, createProduct ,updateProduct,deleteProduct};   