package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        // UUID 8자리까지 잘라서 사용
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        // id는 같은 상태에서 level만 한 단계 증가
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        // id는 같은 상태에서 level만 한 단계 감소
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
