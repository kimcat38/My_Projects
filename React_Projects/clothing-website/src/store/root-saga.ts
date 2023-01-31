import { all, call } from "typed-redux-saga/macro";

import { catetgoriesSaga } from "./categories/category.saga";
import { userSagas } from "./user/user.saga";

export function* rootSaga() {
  yield* all([call(catetgoriesSaga), call(userSagas)]);
}
