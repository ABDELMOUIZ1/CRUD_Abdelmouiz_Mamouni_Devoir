package com.demo28;

import com.demo28.dao.StudentDao;
import com.demo28.dao.StudentDaoImp;
import jakarta.faces.context.FacesContext;

import java.util.List;
import java.util.Locale;
public class StudentBean {
    private Locale locale;
    private StudentDao studentDao;
    private Student newStudent;
    private boolean showForm;
    private Student selectedStudent;
    private int currentPage = 1;
    private int pageSize = 5;
    private List<Student> studentsOnCurrentPage;
    private List<Student> studentsOnNextPage;

    public StudentBean(){
        studentDao = new StudentDaoImp();
        newStudent = new Student();
        showForm = false;
        updateStudentsOnCurrentPage();
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    }
    public void changeLanguage(String languageCode) {
        locale = new Locale(languageCode);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);

    }

    public Locale getLocale() {
        return locale;
    }

    public List<Student> getStudentsOnCurrentPage() {
        return studentsOnCurrentPage;
    }

    public List<Student> getStudentsOnNextPage() {
        return studentsOnNextPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public Student getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(Student newStudent) {
        this.newStudent = newStudent;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public void setShowForm(boolean showForm) {
        this.showForm = showForm;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void deleteStudent(Student student){
        studentDao.deleteStudent(student);
        updateStudentsOnCurrentPage(); // Update student list after deletion
    }

    public void showAddForm() {
        this.showForm = true;
    }

    public void addNewStudent() {
        studentDao.addNewStudent(newStudent);
        showForm = false;
        updateStudentsOnCurrentPage(); // Update student list after addition

    }

    public void modifyStudent(Student student) {
        selectedStudent = student; // Set the selected student for modification
    }

    public void saveModifiedStudent() {
        if (selectedStudent != null) {
            studentDao.modifyStudent(selectedStudent); // Persist the modified student
            selectedStudent = null; // Clear selected student after saving changes
        }
    }

    public void nextPage() {
        currentPage++;
        updateStudentsOnCurrentPage();
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
            updateStudentsOnCurrentPage();
        }
    }

    private void updateStudentsOnCurrentPage() {
        studentsOnCurrentPage = studentDao.pagination(currentPage, pageSize);
        studentsOnNextPage = studentDao.pagination(currentPage + 1, pageSize);
    }
}
