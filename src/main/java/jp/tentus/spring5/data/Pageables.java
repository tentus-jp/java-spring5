package jp.tentus.spring5.data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * ページングに関するコンビニエンスメソッドを提供します。
 */
public final class Pageables {

  private Pageables() {

  }

  /**
   * ページ番号ではなく、offset, count から Pageable オブジェクトを取得します。
   * <p>
   * 取得されたオブジェクトは、下記メソッドがサポート外例外をスローします。
   * <ul>
   * <li>Pageable#first()</li>
   * <li>Pageable#getPageNumber()</li>
   * <li>Pageable#hasPrevious()</li>
   * <li>Pageable#next()</li>
   * <li>Pageable#previousOrFirst()</li>
   * </ul>
   *
   * @param offset オフセット位置。
   * @param count  取得件数。
   * @param sort   並び順。
   * @return Pageable オブジェクト。
   * @see Pageable#first()
   * @see Pageable#getPageNumber()
   * @see Pageable#hasPrevious()
   * @see Pageable#next()
   * @see Pageable#previousOrFirst()
   */
  public static Pageable fromOffset(int offset, int count, Sort sort) {
    return new Pageable() {

      @Override
      public Pageable first() {
        throw new UnsupportedOperationException();
      }

      @Override
      public long getOffset() {
        return offset;
      }

      @Override
      public int getPageNumber() {
        throw new UnsupportedOperationException();
      }

      @Override
      public int getPageSize() {
        return count;
      }

      @Override
      public Sort getSort() {
        return sort;
      }

      @Override
      public boolean hasPrevious() {
        throw new UnsupportedOperationException();
      }

      @Override
      public Pageable next() {
        throw new UnsupportedOperationException();
      }

      @Override
      public Pageable previousOrFirst() {
        throw new UnsupportedOperationException();
      }

      @Override
      public Pageable withPage(int pageNumber) {
        throw new UnsupportedOperationException();
      }

    };
  }

  /**
   * ページ番号から Pageable オブジェクトを取得します。
   *
   * @param pageNumber ページ番号。
   * @param size       ページサイズ。
   * @param sort       並び順。
   * @return Pageable オブジェクト。
   */
  public static Pageable fromPage(int pageNumber, int size, Sort sort) {
    return PageRequest.of(pageNumber, size, sort);
  }

}
