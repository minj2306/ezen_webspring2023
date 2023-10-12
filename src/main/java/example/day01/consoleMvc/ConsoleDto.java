package example.day01.consoleMvc;

import java.time.LocalDate;

public class ConsoleDto {//todo 클래스

    private int no; // todo 번호
    private String title; // todo 내용
    private LocalDate dueDate; // todo 작성일
    private boolean finished; // todo 실행여부

    public ConsoleDto() {
    }

    public ConsoleDto(int no, String title, LocalDate date, boolean finished) {
        this.no = no;
        this.title = title;
        this.dueDate = date;
        this.finished = finished;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return dueDate;
    }

    public void setDate(LocalDate date) {
        this.dueDate = date;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "ConsoleDto{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", finished=" + finished +
                '}'+"\n";
    }
}
