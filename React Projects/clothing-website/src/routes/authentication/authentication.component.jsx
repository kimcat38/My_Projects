import SignUpForm from "../../component/sign-up-form/sign-up-form.component.jsx";
import SignInForm from "../../component/sign-in-form/sign-in-form.component.jsx";

import { AuthenticationContainer } from "./authentication.styles.jsx";

const Authentication = () => {
  return (
    <AuthenticationContainer>
      <SignInForm />
      <SignUpForm />
    </AuthenticationContainer>
  );
};

export default Authentication;
