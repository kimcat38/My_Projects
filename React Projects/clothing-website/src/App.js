import Home from "./routes/home/home.component.jsx";
import Authentication from "./routes/authentication/authentication.component.jsx";
import Navigation from "./routes/navigation/navigation.component.jsx";
import { Routes, Route } from "react-router-dom";

const Shop = () => {
  return <h1> shop page des </h1>;
};

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigation />}>
        <Route index element={<Home />} />
        <Route path="shop" element={<Shop />} />
        <Route path="auth" element={<Authentication />} />
      </Route>
    </Routes>
  );
};

export default App;
