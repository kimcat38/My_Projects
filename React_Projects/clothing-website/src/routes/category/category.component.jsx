import { useState, useEffect, Fragment } from "react";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";

import { selectCategoriesMap } from "../../store/categories/category.selector";

import ProductCard from "../../component/product-card/product-card.component";

import { CategoryContainer, CategoryTitle } from "./category.styles.jsx";

const Category = () => {
  const { category } = useParams();
  const [products, setProducts] = useState([]);

  const categoriesMap = useSelector(selectCategoriesMap);

  useEffect(() => {
    setProducts(categoriesMap[category]);
  }, [category, categoriesMap]);

  return (
    <Fragment>
      <CategoryTitle>{category.toUpperCase()}</CategoryTitle>
      <CategoryContainer>
        {products &&
          products.map((product) => (
            <ProductCard key={product.id} product={product} />
          ))}
      </CategoryContainer>
    </Fragment>
  );
};

export default Category;
