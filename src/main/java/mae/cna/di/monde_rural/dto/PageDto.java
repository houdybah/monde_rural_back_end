package mae.cna.di.monde_rural.dto;

public class PageDto {

    int size;
    long totalElements;
    int totalPages;
    int pageNumber;

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setPageNumber(int pageNumer) {
        this.pageNumber = pageNumer;
    }
}
