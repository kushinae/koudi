export enum ESwitchTarget {
  SEARCH='search',
  MYLTIPLE='multiple',
  SHOW='quick_show',
}

export enum ESpuStatus {
  /** 库存中 */
  IN_STOCK=0,

  /** 提交审核 */
  SUBMIT_REVIEW=1,

  /** 审核中 */
  UNDER_REVIEW=2,

  /** 审核拒绝 */
  REVIEW_REJECTED=3,

  /** 审核通过 */
  REVIEW_PASSED=4,

  /** 发布中 */
  PUBLISH=5,
}