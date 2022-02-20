using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kursova_Rl_
{
    public partial class FrmLogin : Form
    {
        public static string login;
        public static string pass;
        public static string User = "";
        public static bool next;
        public static int countForm=0;
        public FrmLogin()
        {
            
            countForm = 1;
            InitializeComponent();
        }

        private void btnLoginAvt_Click(object sender, EventArgs e)
        {
            try
            {
                if (txtBoxLoginAvt.Text == "" && txtBoxPassAvt.Text == "")
                {
                    MessageBox.Show("Будь ласка заповніть всі поля");
                }
                else
                {
                    if (txtBoxLoginAvt.Text == "Адміністратор" && txtBoxPassAvt.Text == "Адміністратор")
                    {
                        if (FrmTEMATEST.countForm == 0)
                        {
                            User = "Адміністратор";
                            FrmTEMATEST.xto = null;
                            FrmTEMATEST.xto = "Адміністратор";
                            next = true;
                            FrmTEMATEST.vidbtn = 1;
                            MessageBox.Show("Успішно");
                            this.Close();
                            FrmTEMATEST tematest = new FrmTEMATEST();
                            tematest.Show();
                        }
                    }
                    else
                    {
                        FrmTEMATEST.vidbtn = 0;
                        // string login, pass;
                        login = txtBoxLoginAvt.Text;
                        pass = txtBoxPassAvt.Text;
                        IEnumerable<string> a = (File.ReadLines("Data\\User\\User.txt"));
                        int i = 0;
                        next = false;
                        foreach (string str in a)
                        {
                            string[] l = str.Split(' ');
                            if (login == l[0])
                            {
                                if (pass == l[1])
                                {
                                    User = login;
                                    if (FrmTEMATEST.countForm == 0)
                                    {
                                        MessageBox.Show("Успішно");
                                        this.Close();
                                        FrmTEMATEST tematest = new FrmTEMATEST();
                                        tematest.Show();
                                        next = true;
                                        break;
                                    }
                                }
                                else
                                {
                                    MessageBox.Show("Неправильний логін або пароль");
                                }

                            }

                            i++;
                        }
                    }
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show("Перевірте наявність файлів");
            }
        }
        private void FrmLogin_FormClosing(object sender, FormClosingEventArgs e)
        {
            countForm = 0;
        }

        

        private void FrmLogin_ResizeBegin(object sender, EventArgs e)
        {
            Opacity = 0.5;
        }

        private void FrmLogin_ResizeEnd(object sender, EventArgs e)
        {
            Opacity = 1;
        }

        private void FrmLogin_Load(object sender, EventArgs e)
        {
            MaximizeBox = false;
        }

        private void lblPassAvt_Click(object sender, EventArgs e)
        {

        }

        private void txtBoxLoginAvt_TextChanged(object sender, EventArgs e)
        {

        }

        private void lblLoginAvt_Click(object sender, EventArgs e)
        {

        }

        private void txtBoxPassAvt_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtBoxLoginAvt_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (e.KeyChar <= 192 && e.KeyChar != 8 && e.KeyChar != 47 && e.KeyChar != 48 &&
                e.KeyChar != 49 && e.KeyChar != 50 && e.KeyChar != 51 && e.KeyChar != 52 &&
                e.KeyChar != 53 && e.KeyChar != 54 && e.KeyChar != 55 && e.KeyChar != 56 & e.KeyChar != 57)
            {
                e.Handled = true;
            }
        }

        private void txtBoxPassAvt_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (e.KeyChar <= 192 && e.KeyChar != 8 && e.KeyChar != 47 && e.KeyChar != 48 &&
                e.KeyChar != 49 && e.KeyChar != 50 && e.KeyChar != 51 && e.KeyChar != 52 &&
                e.KeyChar != 53 && e.KeyChar != 54 && e.KeyChar != 55 && e.KeyChar != 56 & e.KeyChar != 57)
            {
                e.Handled = true;
            }
        }

        private void btnBack_Click(object sender, EventArgs e)
        {
            countForm = 0;
            this.Hide();
        }
    }
}
